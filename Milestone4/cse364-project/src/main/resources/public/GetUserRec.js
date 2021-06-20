$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/users/recommendation"
    }).then(function(data) {
        $('.gender').append(data.gender);
        $('.age').append(data.age);
        $('.occupation').append(data.age);
        $('.genre').append(data.age);
    });
});
