$(function() {
	$('[data-game-owned="true"]').hide();
	$('[data-game-owned="true"]').parent().children(".game-overlay").children(".game-price").hide();

	$.ajax(
		{
			type: "GET",
			url: "UserServlet",
			data: {
				action: "role",
				cookie: navigator.cookieEnabled,
				jsession: window.location.href.substring(
					window.location.href.lastIndexOf("=") + 1
				)
			},
			error: (data) => {
				$(".game-add").html('<i class="fas fa-sign-in-alt"></i>');
			}
		}
	);

	$(".game-container").click(
		function() {
			window.history.pushState(null, null, "?game=" + $(this).attr("data-game-id"));
			$("#app").load("View/Game.jsp");
			
			if(navigator.cookieEnabled)
				localStorage.setItem("last-page", "Game");
		}
	);
	
	if($("#my-collection").length) {
		$(".game-add").hide();
		$(".game-price").hide();
	}
					
	$(".game-add").off().click(
		function(event) {
			event.stopPropagation();
						
			$.ajax(
				{
					type: "POST",
					url: "CartServlet",
					data: {
						action: "addGame",
						game_id: $(this).parent().attr("data-game-id"),
						cookie: navigator.cookieEnabled,
						jsession: window.location.href.substring(
							window.location.href.lastIndexOf("=") + 1
						)
					},
					success: () => {
						$(".game-confirm").html("Aggiunto <strong>" + $(this).parent().attr("data-game-name") +"</strong> al carrello!");
						$(this).hide();
						if(navigator.cookieEnabled)
							updateCart();
					},
					error: () => {
						$(".game-confirm").html("Non è stato possibile aggiungere <strong>" + $(this).parent().attr("data-game-name") +"</strong> al carrello!");
					}
				}
			);
						
			$(".game-confirm").show(225);
											
			setTimeout(() => { 
				$(".game-confirm").hide("slow")
			}, 4000);
		}
	);
});