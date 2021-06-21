$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/users/recommendation"
    }).then(function(data) {
        $('.title').append(data.title);
        $('.limit').append(data.limit);
    });
});
