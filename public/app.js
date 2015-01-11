(function($, l){
    var mode = 1; // 1=Press button, 2=Select set
    var player;

    var $main = $('.js-field');
    var $pressArea = $('body');
    var $modalTurn = $main.find('.js-turn');
    var $cards = $main.find('img');

    /////////////////////////////////
    // Player selection
    /////////////////////////////////
    $pressArea.keypress(function(e) {
        $main.find('button').each(function() {
            if ($(this).data('key') == e.key && mode === 1) {
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

        var $selectedCards = $cards.filter('.'+cssClass);
        if ($selectedCards.length == 3) {
            var url = '/set/' + player + '/' + get(0) + '/' + get(1) + '/' + get(2);
            $.get(url, function() {
                l.reload();
            });

            $selectedCards.removeClass(cssClass);
            mode = 1;
        }

        function get(i) {
            return $cards.index($selectedCards[i]);
        }
    });
})(jQuery, location);