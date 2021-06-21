$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/users/recommendation" + $_POST['']
    }).then(function(data) {
        $('.gender').append(data.gender);
        $('.age').append(data.age);
        $('.occupation').append(data.occupation);
        $('.genre').append(data.genre);
    });
});
