$(function () {
    $("a#logout-btn").click(function (e) {
        e.preventDefault();
        $("form#logout-form").trigger("submit");
    });
});
