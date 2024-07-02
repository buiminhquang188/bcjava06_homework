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
            } else {
                alert("Xóa thất bại, vui lòng kiểm tra lại");
            }
        });
    });
});