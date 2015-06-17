(function ($, l, a) {
	/////////////////////////////////
	// WebSocket
	/////////////////////////////////
	var ws = $.gracefulWebSocket('wss://' + l.host + '/ws');
	ws.onmessage = function (event) {
		function update($element) {
			try {
				a.element($element[0]).scope().loadData();
			} catch (e) {}
		}

		update($('.js-field .js-cards'));
		update($('.js-points'));
	};

	/////////////////////////////////
	// Angular
	/////////////////////////////////
	var app = a.module('setGameApp', ['ngRoute']);

	app.config(function ($routeProvider) {
		$routeProvider.
		when('/', {
			templateUrl: '/assets/tpl/gamefield.html',
			controller: 'CardCtrl'
		}).
		when('/help', {
			templateUrl: '/assets/tpl/help.html'
		}).
		when('/about', {
			templateUrl: '/assets/tpl/about.html'
		}).
		otherwise({
			redirectTo: '/'
		});
	});

	app.controller('PointsCtrl', function ($scope, $http) {
		$scope.loadData = function () {
			$http.get('/points.json').success(function (data) {
				$scope.points = data;
			});
		}
		$scope.loadData();
	});

	app.controller('RestartCtrl', function ($scope, $http) {
		$scope.click = function () {
			$http.get('/reset.json');
		}
	});

	app.controller('SaveCtrl', function ($scope, $http) {
		$scope.saveGame = function () {
			$http.get('/save').success(function (res) {
				console.log('saved mock');
			});
		}
	});

	app.controller('LoadCtrl', function ($scope, $http) {
		$scope.loadGame = function () {
			$http.get('/load/' + $scope.gameId).success(function (res) {
				console.log('load mock');
			});
		}
	});

	app.controller('CardCtrl', function ($scope, $http) {
		$scope.loadData = function () {
			$http.get('/cards.json').success(function (data) {
				$scope.cards = data.cards;
				$scope.player = data.player;
			});
		}

		$scope.loadData();

		var mode = 1; // 1=Press button, 2=Select set

		var $main = $('.js-field');
		var $pressArea = $('body');
		var $modalTurn = $main.find('.js-turn');
		var $modalSetGood = $main.find('.js-set-good');
		var $modalSetBad = $main.find('.js-set-bad');
		var $cards = $main.find('.js-cards');

		var selectClass = 'selected';
		var tipClass = 'highlight';

		var clearTip = function () {
			$cards.find('img.' + tipClass).removeClass(tipClass);
		};

		/////////////////////////////////
		// Player selection
		/////////////////////////////////
		$pressArea.keypress(function (e) {
			$main.find('button').each(function () {
				if ($(this).data('key') == e.which && mode === 1) {
					mode = 2;
					$modalTurn.modal();
					clearTip();
				}
			});
		});

		/////////////////////////////////
		// Card selection
		/////////////////////////////////
		$cards.on('click', 'img', function () {
			if (mode == 2) {
				clearTip();
				$(this).addClass(selectClass);
			}

			var $selectedCards = $main.find('img.' + selectClass);

			if ($selectedCards.length == 3) {
				var url = '/set/' + get(0) + '/' + get(1) + '/' + get(2);
				$.get(url, function (data) {
					(data) ? $modalSetGood.modal(): $modalSetBad.modal();
				});

				$selectedCards.removeClass(selectClass);
				mode = 1;
			}

			function get(i) {
				return $selectedCards.eq(i).data('field');
			}
		});

		$scope.showTip = function () {
			$http.get('/solve.json').success(function (data) {
				$cards.find('img').each(function () {
					var id = $(this).data('field');
					if ($.inArray(id, data) > -1) {
						$(this).addClass(tipClass);
					}
				})
			});
		}
	});
})(jQuery, location, angular);