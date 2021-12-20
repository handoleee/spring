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
        name : '결제',
        amount : 주문개수,
        buyer_email : '구매자 이메일${}',
        buyer_name : '구매자 이름${}',
        buyer_tel : '구매자 번호${}',
        buyer_addr : '구매자 주소${}',
        buyer_postcode : '구매자 주소${maddr1, maddr2, maddr3}',
        m_redirect_url : 'redirect url'
    }, function(rsp) {
        if ( rsp.success ) {
            var msg = '결제가 완료되었습니다.';
            location.href='recipesucess?loginMember=${sessionScope.loginMember}';
        } else {
            var msg = '결제에 실패하였습니다.';
            rsp.error_msg;
            
        }
    });


    </script>
</head>
<body>

</body>
</html>