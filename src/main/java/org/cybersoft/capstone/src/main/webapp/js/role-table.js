$(function () {
    $("a.btn-xoa").click(function (e) {
        e.preventDefault();
        const id = $(this).data("id");

        $.ajax({
            method: "DELETE",
            url: `http://localhost:8080/crmapp/api/role/${id}`
        }).done((result) => {
            if (result.data) {
                this.closest("tr").remove();
            }

            if (result.message === 'NOT_ALLOWED') {
                const alert = $(".alert.alert-danger");
                alert.removeClass("hidden");

                const timeOutId = setTimeout(() => {
                    alert.addClass("hidden")
                }, 3000)

                window.onbeforeunload = () => {
                    clearTimeout(timeOutId);
                }
            } else if (result.message !== 'Success') {
                alert("Xóa thất bại, vui lòng kiểm tra lại");
            }
        });
    });
});
