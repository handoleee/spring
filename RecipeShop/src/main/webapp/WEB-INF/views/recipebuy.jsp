<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script>
  

    var IMP = window.IMP; 
    IMP.init('imp21172742'); 
    IMP.request_pay({
    	pg : "kakaopay", 
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '����',
        amount : �ֹ�����,
        buyer_email : '������ �̸���${}',
        buyer_name : '������ �̸�${}',
        buyer_tel : '������ ��ȣ${}',
        buyer_addr : '������ �ּ�${}',
        buyer_postcode : '������ �ּ�${maddr1, maddr2, maddr3}',
        m_redirect_url : 'redirect url'
    }, function(rsp) {
        if ( rsp.success ) {
            var msg = '������ �Ϸ�Ǿ����ϴ�.';
            location.href='recipesucess?loginMember=${sessionScope.loginMember}';
        } else {
            var msg = '������ �����Ͽ����ϴ�.';
            rsp.error_msg;
            
        }
    });


    </script>
</head>
<body>

</body>
</html>