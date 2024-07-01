$(function () {
    $("a.btn-xoa").click(function () {
        const id = $(this).data("id");

        $.ajax({
            method: "DELETE",
            url: `http://localhost:8080/crmapp/api/user/${id}`
        }).done((result) => {
            if (result.data) {
                this.closest("tr").remove();
            } else {
                alert("Xóa thất bại, vui lòng kiểm tra lại");
            }
        })
    })
})