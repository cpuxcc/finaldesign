
$(document).ready(function() {

    $(".login-btn").click(function() {

        var username=$("#username").val();
        var userpwd=$("#userpwd").val();

        if(username==='' || userpwd===''){
            alert('用户名或密码不能为空!');
            createCode();
            return;
        }
        if(!validateCode())
        {
            return;
        }

        $(this).text("登录中……");

        $.ajax({
            url: $("#login-url").val(),
            type: "post",
            headers: {'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')},
            data: {
                "username": username,
                "userpwd": userpwd
            },
            success: function(result) {
                var res = result;
                if (res.status == 501) {
                    $(".err-content").text(res.msg);
                    $(".err-message").css("visibility", "visible");
                    createCode();
                    var t = setInterval(function() {
                        $(".err-message").css("visibility", "hidden");
                        clearInterval(t);
                    }, 2000);
                    $("#userpwd").val("");
                    $(".login-btn").text("登  录");
                } else {
                    location.href = res.data.url;
                }
            },
            error: function(errmess) {
                console.log(errmess);
            }
        });

    });

    $("body").on("keydown", function(e) {
        if (e.keyCode === 13) {
            $(".login-btn").click();
        }
    })

});
