$(document).ready(function(e) {

	$("#form").validate({
		rules : {
			title : {
				required : true,
				minlength : 5,
				maxlength : 20
			},
			author : {
				required : true,
				minlength : 10,
				maxlength : 30
			}

		},
		// Custom message for error
		messages : {
			title : {
				required : "You must enter title",
				minlength : "Title length must be greater than 5 character",
				maxlength : "Title length must be less than 20 character"
			},
			author : {
				required : "You must enter author",
				minlength : "Author length must be greater than 10 character",
				maxlength : "Author length must be less than 30 character"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});

	$('#addNew').click(function() {
		$('#header').html("ADD NEW BOOK");
		$('[name="title"]').val("");
		$('[name="id"]').val("");
		$('[name="author"]').val("");
		$('[name="description"]').val("");
		document.getElementById("myForm").style.display = "block";
	});

	$('#btn-submit').click(function() {
		var form = $("#form");
		form.validate();

		if (form.valid()) {
			var dataTitle = $('[name="title"]').val();
			var dataId = $('[name="id"]').val();
			var dataDesciption = $('[name="description"]').val();
			var dataAuthor = $('[name="author"]').val();

			var data = {
				id : dataId,
				title : dataTitle,
				description : dataDesciption,
				author : dataAuthor
			};

			$.ajax({
				url : '/add-or-edit-book',
				type : 'POST',
				data : JSON.stringify(data),
				dataType : 'json',
				contentType : 'application/json'
			}).done(function(result) {
				var title = "";
				var content = ""
				if (dataId == "") {
					title = "Add new book";
					content = "Add new book susccess";
				} else {
					title = "Edit new book";
					content = "Edit new book susccess";
				}
				$.jGrowl(content, {
					sticky : false,
					theme : 'growl-success',
					header : title,
					life : 3000,
					position : 'top-right'
				});

			}).fail(function() {
				$.jGrowl(content, {
					sticky : false,
					theme : 'growl-error',
					header : title,
					life : 3000,
					position : 'top-right'
				});
			});
			if (dataId == "") {
				setTimeout(function() {
					document.location.href = '/book/page/1';
				}, 1000);
			} else {
				setTimeout(function() {
					document.location.href = document.location.href;
				}, 1000);
			}
		}
	});

});

function closeForm() {
	document.getElementById("myForm").style.display = "none";
}

function editBook(id) {
	$.ajax({
		url : '/get-book/' + id,
		type : 'GET',
		data : {},
		dataType : 'json',
		contentType : 'application/json'
	}).done(function(result) {
		$('#header').html("EDIT BOOK");
		$('[name="title"]').val(result.title);
		$('[name="id"]').val(result.id);
		$('[name="author"]').val(result.author);
		$('[name="description"]').val(result.description);
		document.getElementById("myForm").style.display = "block";
	}).fail(function() {

	});
}

function deleteBook(id) {
	if (confirm("Are you sure you want to delete this?")) {
		$.ajax({
			url : '/delete-book',
			type : 'POST',
			data : JSON.stringify(id),
			dataType : 'json',
			contentType : 'application/json'
		}).done(function(result) {
			$.jGrowl("Delete book susccess", {
				sticky : false,
				theme : 'growl-success',
				header : "Delete book",
				life : 3000,
				position : 'top-right'
			});

			setTimeout(function() {
				document.location.href = document.location.href;
			}, 1000);
		}).fail(function() {
			$.jGrowl("Deleted book error", {
				sticky : false,
				theme : 'growl-error',
				header : "Deleted book",
				life : 3000,
				position : 'top-right'
			});
		});
	} else {
		return false;
	}

}
