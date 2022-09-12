<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>excel</title>
</head>
<body>

<form id="formFile" method="post" action="##"
      class="report_form" target="_blank">
    <div class="easyui-panel" title="Upload File"
         style="width: 450px; padding: 30px 70px 50px 70px">
        <div style="margin-bottom: 20px">
            <div>物料代码文件：</div>
            <input class="import-btn" type="file" accept=".xls,.xlsx">
        </div>
    </div>
</form>
</body>
</html>

<script type="text/javascript">
    $(function () {
        $('.import-btn').change(function () {
            var formData = new FormData(),
                name = $(this).val()
            formData.append('file', $(this)[0].files[0])
            // 此处可传入多个参数
            formData.append('name', name)
            console.log(name + ', ' + $(this)[0].files[0])
            $.ajax({
                url: "${ctx}/bom/getLatestOrder.do",
                type: 'post',
                async: false,
                data: formData,
                // 告诉jQuery不要去处理发送的数据
                processData: false,
                // 告诉jQuery不要去设置Content-Type请求头
                contentType: false,
                beforeSend: function () {
                    console.log('正在进行，请稍候')
                },
                success: function (data) {
                    if (data.message != null) {
                        $.messager.alert("提示", data.message);
                    }
                    if (data.infos != null) {
                        location.href = "${ctx }/bom/messageExport.do";
                    }
                }
            })
        })
    });

</script>
