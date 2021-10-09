<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: quans
  Date: 10/6/21
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" class="anyflexbox boxshadow display-table">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Sunmax - Thanh toán đơn hàng"/>

    <title>Sunmax - Thanh toán đơn hàng</title>


    <link rel="shortcut icon" href="user/image/favicon.ico" type="user/image/x-icon"/>

    <script src="user/js/jquery-2.1.3.min.js?4" type="text/javascript"></script>
    <link href="user/css/bootstrap.min.css?20171025" rel="stylesheet" type="text/css"/>
    <link href="user/css/nprogress.css?20171025" rel="stylesheet" type="text/css"/>
    <link href="user/css/font-awesome.min.css?20171025" rel="stylesheet" type="text/css"/>
    <link href="user/css/select2-min.css?20171025" rel="stylesheet" type="text/css"/>
    <link href="user/css/checkout.css?20190719" rel="stylesheet" type="text/css"/>
    <link href="user/css/checkout.css?1564624970765" rel="stylesheet" type="text/css"/>

</head>

<body class="body--custom-background-color ">
<div class="banner" data-header="">
    <div class="wrap">
        <div class="shop logo logo--left ">

            <h1 class="shop__name">
                <a href="/">
                    Sunmax
                </a>
            </h1>

        </div>
    </div>
</div>
<button class="order-summary-toggle" bind-event-click="Bizweb.StoreCheckout.toggleOrderSummary(this)">
    <div class="wrap">
        <h2>
            <label class="control-label">Đơn hàng</label>
            <label class="control-label hidden-small-device">
                (2 sản phẩm)
            </label>
            <label class="control-label visible-small-device inline">
                (2)
            </label>
        </h2>
        <a class="underline-none expandable pull-right" href="javascript:void(0)">
            Xem chi tiết
        </a>
    </div>
</button>


<div context="paymentStatus"
     define='{ paymentStatus: new Bizweb.PaymentStatus(this,{payment_processing:"",payment_provider_id:"",payment_info:{} }) }'>

</div>
<form method="post" action="" data-toggle="validator" class="content stateful-form formCheckout">
    <div class="wrap" context="checkout"
         define='{checkout: new Bizweb.StoreCheckout(this,{ token: "89d40cf0c2744cd8bf7df9d7ea511bd4", email: "", totalOrderItemPrice: 41700000.0000, shippingFee: 0, freeShipping: false, requiresShipping: true, existCode: false, code: "", discount: 0, settingLanguage: "vi", moneyFormat: "{{amount_no_decimals_with_comma_separator}}₫", discountLabel: "Miễn phí", districtPolicy: "optional", wardPolicy: "hidden", district: "", ward: "", province:"", otherAddress: false, shippingId: 0, shippingMethods: [], customerAddressId: 0, reductionCode: "" })}'>
        <div class='sidebar '>
            <div class="sidebar_header">
                <h2>
                    <label class="control-label">Đơn hàng (${size} sản phẩm)</label>
                </h2>
                <hr class="full_width"/>
            </div>
            <form method="post">
                <div class="sidebar__content">
                    <div class="order-summary order-summary--product-list order-summary--is-collapsed">
                        <div class="summary-body summary-section summary-product">
                            <div class="summary-product-list">
                                <table class="product-table">
                                    <tbody>
                                    <c:set var="total" value="${0}"/>
                                    <c:forEach items="${cartList}" var="cart">
                                        <tr class="product product-has-image clearfix">
                                            <td>
                                                <div class="product-thumbnail">
                                                    <div class="product-thumbnail__wrapper">

                                                        <img src="${cart.image}"
                                                             class="product-thumbnail__image"/>

                                                    </div>
                                                    <span class="product-thumbnail__quantity" aria-hidden="true">${cart.quantity}</span>
                                                </div>
                                            </td>
                                            <td class="product-info">
                                                    <span class="product-info-name">
                                                            ${cart.productName}
                                                    </span>
                                            </td>
                                            <td class="product-price text-right">
                                                <fmt:formatNumber type="number" maxFractionDigits = "0"  value="${cart.saleOff*cart.quantity}"/>
                                            </td>
                                        </tr>
                                        <c:set var="total" value="${total + cart.saleOff*cart.quantity}"/>
                                    </c:forEach>

                                    </tbody>
                                </table>

                            </div>
                        </div>
                        <hr class="m0"/>
                    </div>
                    <%--                <div class="order-summary order-summary--discount">--%>
                    <%--                    <div class="summary-section">--%>
                    <%--                        <div class="form-group m0"--%>
                    <%--                             bind-show="!existCode || !applyWithPromotion || code == null || !code.length">--%>
                    <%--                            <div class="field__input-btn-wrapper">--%>
                    <%--                                <div class="field__input-wrapper">--%>
                    <%--                                    <input bind="code" name="code" type="text" class="form-control discount_code"--%>
                    <%--                                           placeholder="Nhập mã giảm giá" value="  " id="checkout_reduction_code"/>--%>
                    <%--                                </div>--%>
                    <%--                                <button bind-event-click="reduction_code = false, caculateShippingFee('')"--%>
                    <%--                                        class="btn btn-primary event-voucher-apply" type="button">Áp dụng--%>
                    <%--                                </button>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                        <div bind-class="{'warning' : existCode && !freeShipping && discount == 0,'success' : existCode && ( freeShipping || discount >0 )}"--%>
                    <%--                             class="clearfix hide"--%>
                    <%--                             bind-show="code!= null && code.length && existCode && applyWithPromotion">--%>
                    <%--                            <div class="pull-left">--%>
                    <%--                                <i class="fa fa-check applied-discount-status-success" aria-hidden="true"></i>--%>
                    <%--                                <i class="fa fa-exclamation-triangle applied-discount-status-warning"--%>
                    <%--                                   aria-hidden="true"></i>--%>
                    <%--                            </div>--%>
                    <%--                            <div bind="code" class="pull-left applied-discount-code">--%>

                    <%--                            </div>--%>
                    <%--                            <div bind="(discountShipping && freeShipping) ? 'Miễn phí' : money(discount,'{{amount_no_decimals_with_comma_separator}}₫')"--%>
                    <%--                                 class="pull-right">--%>

                    <%--                                0--%>

                    <%--                            </div>--%>
                    <%--                            <input bind-event-click="removeCode('')" class="btn btn-delete" type="button" value="×"--%>
                    <%--                                   name="commit">--%>
                    <%--                        </div>--%>
                    <%--                        <div class="error mt10 hide" bind-show="inValidCode">--%>
                    <%--                            Mã khuyến mãi không hợp lệ--%>
                    <%--                        </div>--%>
                    <%--                        <div class="error mt10 hide" bind-show="!applyWithPromotion && existCode">--%>
                    <%--                            Mã khuyến mãi không được áp dụng chung với chương trình khuyến mãi--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <hr class="m0"/>--%>
                    <%--                </div>--%>
                    <div class="order-summary order-summary--total-lines">
                        <div class="summary-section border-top-none--mobile">
                            <div class="total-line total-line-subtotal clearfix">
                                <span class="total-line-name pull-left">
                                    Tạm tính
                                </span>
                                <span bind="money(totalOrderItemPrice - discount,'{{amount_no_decimals_with_comma_separator}}₫')"
                                      class="total-line-subprice pull-right">
                                    <fmt:formatNumber type="number" maxFractionDigits = "0"  value="${total}"/>₫
                                </span>
                            </div>
                            <div class="total-line total-line-shipping clearfix" bind-show="requiresShipping">
                                <span class="total-line-name pull-left">
                                    Phí vận chuyển
                                </span>
                                <span bind="shippingFee >  0 ? money(shippingFee,'{{amount_no_decimals_with_comma_separator}}₫') : ((requiresShipping && shippingMethods.length == 0) ? 'Khu vực này không hỗ trợ vận chuyển': 'Miễn phí')"
                                      class="total-line-shipping pull-right"
                                      bind-show="ShippingProvinceId || BillingProvinceId && !otherAddress || (requiresShipping && shippingMethods.length > 0)">
                                        Miễn phí
                                </span>
                            </div>
                            <div class="total-line total-line-total clearfix">
                                <span class="total-line-name pull-left">
                                    Tổng cộng
                                </span>
                                <span bind="money(totalOrderItemPrice + (isNaN(shippingFee) ? 0 : shippingFee) - discount,'{{amount_no_decimals_with_comma_separator}}₫')"
                                      class="total-line-price pull-right">
                                    <fmt:formatNumber type="number" maxFractionDigits = "0"  value="${total}"/>₫
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group clearfix hidden-sm hidden-xs">
                        <div class="field__input-btn-wrapper mt10">
                            <a class="previous-link" href="/user?action=cart">
                                <i class="fa fa-angle-left fa-lg" aria-hidden="true"></i>
                                <span>Quay về giỏ hàng</span>
                            </a>
                            <button onclick="swal('Đặt hàng thành công!', '', 'success');" type="submit" class="btn btn-primary" id="liveToastBtn">
                                Submit
                            </button>

                        </div>
                    </div>
                    <div class="form-group has-error">
                        <div class="help-block ">
                            <ul class="list-unstyled">

                            </ul>
                        </div>
                    </div>
                </div>

            </form>
        </div>
        <div class="main" role="main">
            <div class="main_header">
                <div class="shop logo logo--left ">

                    <h1 class="shop__name">
                        <a href="/">
                            Sunmax
                        </a>
                    </h1>

                </div>
            </div>
                <div class="main_content">
                    <div class="row">
                        <div class="col-md-6 col-lg-6">
                            <div class="section" define="{billing_address: {}}">
                                <div class="section__header">
                                    <div class="layout-flex layout-flex--wrap">
                                        <h2 class="section__title layout-flex__item layout-flex__item--stretch">
                                            <i class="fa fa-id-card-o fa-lg section__title--icon hidden-md hidden-lg"
                                               aria-hidden="true"></i>
                                            <label class="control-label">Thông tin mua hàng</label>
                                        </h2>

                                    </div>
                                </div>
                                <div class="section__content">
                                    <div class="form-group" bind-class="{'has-error' : invalidEmail}">
                                        <div>
                                            <label for="_email">
                                                Email
                                            </label>
                                            <label class="field__input-wrapper" bind-class="{ 'js-is-filled': email }">
<%--                                                    <span class="field__label" bind-event-click="handleClick(this)">--%>
<%--                                                        Email--%>
<%--                                                    </span>--%>
                                                <input name="email" type="email" bind-event-change="changeEmail()"
                                                       bind-event-focus="handleFocus(this)"
                                                       bind-event-blur="handleFieldBlur(this)"
                                                       class="field__input form-control" id="_email"
                                                       data-error="Vui lòng nhập email đúng định dạng" required name="Email"
                                                       value=""
                                                       pattern="^([a-zA-Z0-9_\-\.\+]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$"
                                                       bind="email"/>
                                            </label>
                                        </div>
                                        <div class="help-block with-errors">
                                        </div>
                                    </div>

                                    <div class="billing">
                                        <div>
                                            <div class="form-group">
                                                <label for="_billing_address_last_name">
                                                    Họ và tên
                                                </label>
                                                <div class="field__input-wrapper"
                                                     bind-class="{ 'js-is-filled': billing_address.full_name }">
<%--                                                    <span class="field__label" bind-event-click="handleClick(this)">--%>
<%--                                                        Họ và tên--%>
<%--                                                    </span>--%>
                                                    <input name="name" type="text"
                                                           bind-event-change="saveAbandoned()"
                                                           bind-event-focus="handleFocus(this)"
                                                           bind-event-blur="handleFieldBlur(this)"
                                                           class="field__input form-control" id="_billing_address_last_name"
                                                           data-error="Vui lòng nhập họ tên" required
                                                           bind="billing_address.full_name"/>
                                                </div>
                                                <div class="help-block with-errors"></div>
                                            </div>

                                            <div class="form-group">
                                                <label for="_billing_address_phone">
                                                    Số điện thoại
                                                </label>
                                                <div class="field__input-wrapper"
                                                     bind-class="{ 'js-is-filled': billing_address.phone }">
<%--                                                        <span class="field__label" bind-event-click="handleClick(this)">--%>
<%--                                                            Số điện thoại--%>
<%--                                                        </span>--%>
                                                    <input name="phone" bind-event-change="saveAbandoned()"
                                                           type="tel" bind-event-focus="handleFocus(this)"
                                                           bind-event-blur="handleFieldBlur(this)"
                                                           class="field__input form-control" id="_billing_address_phone"
                                                           data-error="Vui lòng nhập số điện thoại"
                                                           pattern="^([0-9,\+,\-,\(,\),\.]{8,20})$"
                                                           bind="billing_address.phone"/>
                                                </div>
                                                <div class="help-block with-errors"></div>
                                            </div>


                                            <div class="form-group">
                                                <label for="_billing_address_address1">
                                                    Địa chỉ
                                                </label>
                                                <div class="field__input-wrapper"
                                                     bind-class="{ 'js-is-filled': billing_address.address1 }">
<%--                                                        <span class="field__label" bind-event-click="handleClick(this)">--%>
<%--                                                            Địa chỉ--%>
<%--                                                        </span>--%>
                                                    <input name="address"
                                                           bind-event-change="saveAbandoned()" type="text"
                                                           bind-event-focus="handleFocus(this)"
                                                           bind-event-blur="handleFieldBlur(this)"
                                                           class="field__input form-control" id="_billing_address_address1"
                                                           bind="billing_address.address1"/>
                                                </div>
                                                <div class="help-block with-errors"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="section" bind-class="{ 'pt0': otherAddress, 'pt10': !otherAddress}">
                                <div class="section__content">
                                    <div class="form-group m0">
                                        <div>
                                            <label for="note">
                                                Ghi chú
                                            </label>
                                            <label class="field__input-wrapper" bind-class="{'js-is-filled': note}"
                                                   style="border: none">

                                                <textarea name="note"
                                                          id="note"
                                                          bind-event-change="saveAbandoned()"
                                                          bind-event-focus="handleFocus(this)"
                                                          bind-event-blur="handleFieldBlur(this)"
                                                          bind="note"
                                                          class="field__input form-control m0"></textarea>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-6">
                            <div class="section shipping-method hide" bind-show="shippingMethods.length > 0">
                                <div class="section__header">
                                    <h2 class="section__title">
                                        <i class="fa fa-truck fa-lg section__title--icon hidden-md hidden-lg"
                                           aria-hidden="true"></i>
                                        <label class="control-label">Vận chuyển</label>
                                    </h2>
                                </div>
                                <div class="section__content">
                                    <div class="content-box">

                                    </div>
                                </div>
                            </div>
                            <div class="section payment-methods" bind-class="{'p0--desktop': shippingMethods.length == 0}">
                                <div class="section__header">
                                    <h2 class="section__title">
                                        <i class="fa fa-credit-card fa-lg section__title--icon hidden-md hidden-lg"
                                           aria-hidden="true"></i>
                                        <label class="control-label">Thanh toán</label>
                                    </h2>
                                </div>
                                <div class="section__content">
                                    <div class="content-box">

                                        <div class="content-box__row">
                                            <div class="radio-wrapper">
                                                <div class="radio__input">
                                                    <input class="input-radio" type="radio" value="290343"
                                                           name="PaymentMethodId" id="payment_method_290343"
                                                           data-check-id="4" bind="payment_method_id" checked>
                                                </div>
                                                <label class="radio__label" for="payment_method_290343">
                                                    <span class="radio__label__primary">Thanh toán khi giao hàng (COD)</span>
                                                    <span class="radio__label__accessory">
                    <ul>
                        <li class="payment-icon-v2 payment-icon--4">

								<i class="fa fa-money payment-icon-fa" aria-hidden="true"></i>

                        </li>
                    </ul>
                </span>
                                                </label>
                                            </div> <!-- /radio-wrapper-->
                                        </div>

                                        <div class="radio-wrapper content-box__row content-box__row--secondary hide"
                                             id="payment-gateway-subfields-290343" bind-show="payment_method_id == 290343">
                                            <div class="blank-slate">
                                                <p>cod</p>


                                            </div>
                                        </div>


                                        <a href="javascript:void(0)" data-toggle="modal" data-target="#moca-modal"
                                           data-backdrop="static" data-keyboard="false" class="trigger-moca-modal"
                                           style="display: none;" title="Thanh toán qua Moca">
                                        </a>
                                        <a href="javascript:void(0)" data-toggle="modal" data-target="#qr-error-modal"
                                           class="trigger-qr-error-modal" style="display: none;" title="Lỗi thanh toán">
                                        </a>
                                        <a data-toggle="modal" data-target="#zalopay_modal" data-backdrop="static"
                                           data-keyboard="false" class="trigger-zalopay-modal" style="display: none;"
                                           title="Thanh toán qua ZaloPay">
                                        </a>
                                        <div class="modal fade moca-modal" id="moca-modal" tabindex="-1" role="dialog">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div>
                                                        <iframe style="border: 0px; width: 100%; height: 100%;"
                                                                src=""></iframe>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal fade" id="qr-error-modal" data-width="" tabindex="-1"
                                             role="dialog">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-body">
                                                        <button aria-hidden="true" data-dismiss="modal" class="close"
                                                                type="button">×
                                                        </button>
                                                        <div class="invalid_order">
                                                            <p>Giao dịch của bạn chưa đủ hạn mức thanh toán</p>
                                                            <p>Hạn mức tối thiểu để thanh toán được là <span>1đ</span></p>
                                                            <p>Vui lòng chọn hình thức thanh toán khác</p>
                                                        </div>
                                                        <div class="custom_error_message"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal fade zalopay_modal" id="zalopay_modal" tabindex="-1"
                                             role="dialog">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-body">
                                                        <div style="display:flex; justify-content: space-around;">
                                                            <div class="qr-wrapper">
                                                                <img/>
                                                                <div class="qr-timer-container">
                                                                    Thời gian quét mã QR để thanh toán còn <span
                                                                        class="qr-timer" style="color:#4286f6;">300</span>
                                                                    giây
                                                                </div>
                                                            </div>
                                                            <div class="qr-guide-content">
                                                                <p><b>Thực hiện theo hướng dẫn sau để thanh toán:</b></p>
                                                                <p>Bước 1: Mở ứng dụng ZaloPay</p>
                                                                <p>Bước 2: Chọn "Thanh Toán" <img
                                                                        src="user/image/barcode-zalo.png"
                                                                        class="zalopay-qr-payment-icon"></img> và quét mã QR
                                                                    code bên cạnh</p>
                                                                <p>Bước 3: Hoàn thành các bước thanh toán theo hướng dẫn
                                                                    trên ứng dụng</p>
                                                            </div>
                                                        </div>
                                                        <div style="justify-content: flex-end;display: flex;">
                                                            <button type="button" class="btn btn-default"
                                                                    data-dismiss="modal">Hủy thanh toán
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="section hidden-md hidden-lg">
                                <div class="form-group clearfix m0">
                                    <button type="submit" class="btn btn-primary"></button>
                                </div>
                                <div class="text-center mt20">
                                    <a class="previous-link" href="/user?action=cart">
                                        <i class="fa fa-angle-left fa-lg" aria-hidden="true"></i>
                                        <span>Quay về giỏ hàng</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            <div class="main_footer footer unprint">


                <div class="mt10"></div>
            </div>
            <div class="modal fade" id="refund-policy" data-width="" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">Chính sách hoàn trả</h4>
                        </div>
                        <div class="modal-body">
                            <pre></pre>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="privacy-policy" data-width="" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">Chính sách bảo mật</h4>
                        </div>
                        <div class="modal-body">
                            <pre></pre>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="terms-of-service" data-width="" tabindex="-1" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                            <h4 class="modal-title">Điều khoản sử dụng</h4>
                        </div>
                        <div class="modal-body">
                            <pre></pre>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<script src="user/js/jquery-2.1.3.min.js?20171025" type="text/javascript"></script>
<script src="user/js/bootstrap.min.js?20171025" type="text/javascript"></script>
<script src="user/js/twine.min.js?20171025" type="text/javascript"></script>
<script src="user/js/validator.min.js?20171025" type="text/javascript"></script>
<script src="user/js/nprogress.js?20171025" type="text/javascript"></script>
<script src="user/js/money-helper.js?20171025" type="text/javascript"></script>
<script src="user/js/select2-full-min.js?20171025" type="text/javascript"></script>

<script src="user/js/ua-parser.pack.js?20180611" type='text/javascript'></script>
<script src="user/js/checkout.js?20190701" type="text/javascript"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</body>
</html>
