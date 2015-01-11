(function($, l, a){
    /////////////////////////////////
    // WebSocket
    /////////////////////////////////
    var ws = $.gracefulWebSocket('ws://' + l.host + '/ws');
    ws.onmessage = function (event) {
        function update($element) {
            try {
                a.element($element[0]).scope().loadData();
            } catch(e) {}
        }

        var $main = $('.js-field');
        update($main.find('.js-cards'));
    };

    /////////////////////////////////
    // Angular
    /////////////////////////////////
    var app = a.module('setGameApp', ['ngRoute']);

    app.config(function($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: '/assets/tpl/gamefield.html',
                controller: 'CardCtrl'
            }).
            when('/help', {
                templateUrl: '/assets/tpl/help.html'
            }).
            otherwise({
                redirectTo: '/'
            });
    });

    app.controller('CardCtrl', function ($scope, $http) {
        $scope.loadData = function() {
            $http.get('/cards.json').success(function(data) {
                $scope.cards = data;
            });
        }

        $scope.loadData();

        var mode = 1; // 1=Press button, 2=Select set
        var player;

        var $main = $('.js-field');
        var $pressArea = $('body');
        var $modalTurn = $main.find('.js-turn');
        var $modalSetGood = $main.find('.js-set-good');
        var $modalSetBad = $main.find('.js-set-bad');
        var $cards = $main.find('.js-cards');

        /////////////////////////////////
        // Player selection
        /////////////////////////////////
        $pressArea.keypress(function(e) {
            $main.find('button').each(function() {
                if ($(this).data('key') == e.which && mode === 1) {
                    player = $(this).data('player');
                    mode = 2;

                    $modalTurn.find('.js-name').text($(this).data('name'));
                    $modalTurn.modal();
                }
            });
        });

        /////////////////////////////////
        // Card selection
        /////////////////////////////////
        $main.on('click', 'img', function() {
            var cssClass = 'selected';
            if (mode == 2) {
                $(this).addClass(cssClass);
            }

            var $selectedCards = $main.find('img.'+cssClass);

            if ($selectedCards.length == 3) {
                var url = '/set/' + player + '/' + get(0) + '/' + get(1) + '/' + get(2);
                $.get(url, function(data) {
                    (data) ? $modalSetGood.modal() : $modalSetBad.modal();
                });

                $selectedCards.removeClass(cssClass);
                mode = 1;
            }

            function get(i) {
                return $selectedCards.eq(i).data('field');
            }
        });
    });
})(jQuery, location, angular);
