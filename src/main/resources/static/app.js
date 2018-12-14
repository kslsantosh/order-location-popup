var stompClient = null;
var markers = [];
// var contentString = '<div id="content">'+
//         '<div id="siteNotice">'+
//         '</div>'+
//         '<h1 id="firstHeading" class="firstHeading">Licious</h1>'+
//         '<div id="bodyContent">'+
//         '<p><b>Santosh</b>, Bengaluru </p>'+
//         '</div>'+
//         '</div>';

//var contentString = '<div id="content" class="center"> <span class="popover above">Hey bro, cool popover!</span></div>'
//var contentString = '<p id="hook">Hello World!</p>'
//var contentString = '<div class="popover left in" role="tooltip" display: block; opacity: 1; transform-origin: 50% 50% 0px;"><div class="arrow" style="top: 50%;"></div><h3 class="popover-title">Popover on left</h3><div class="popover-content">Vivamus sagittis lacus vel augue laoreet rutrum faucibus.</div></div>'
var contentString = '<div class="bs-callout bs-callout-info" style="margin:0px" id="callout-type-dl-truncate"> <h4>Santosh</h4> <p>Licious Order</p> </div>'

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/websocket-example');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/orderNotification', function (greeting) {
            showGreeting(JSON.parse(greeting.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    var infowindow = new google.maps.InfoWindow({
        content: contentString,
        maxWidth: 120,
        maxHeight:20
    });

    myLatLng = {lat: message["latitude"], lng: message["longitude"]}
    // BLR
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map1,
        label: "Santosh",
        icon: {
            url: "pin.svg",
            scaledSize: new google.maps.Size(40, 40)
        },
        animation: google.maps.Animation.DROP
    });
    // setTimeout(function () { infowindow.open(map1, marker); }, 1000);
    // setTimeout(function () { infowindow.close(); }, 2000);
    // HYD
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map2,
        label: "Santosh",
        icon: {
            url: "pin.svg",
            scaledSize: new google.maps.Size(40, 40)
        },
        animation: google.maps.Animation.DROP
    });
    // setTimeout(function () { infowindow.open(map2, marker); }, 1000);
    // setTimeout(function () { infowindow.close(); }, 2000);
    // NCR
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map3,
        label: "Santosh",
        icon: {
            url: "pin.svg",
            scaledSize: new google.maps.Size(40, 40)
        },
        animation: google.maps.Animation.DROP
    });
    // setTimeout(function () { infowindow.open(map3, marker); }, 1000);
    // setTimeout(function () { infowindow.close(); }, 2000);
    
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    connect();
});

window.initMap = function  initMap() {
    console.log("------Inside initMap()-----")
    var blrLatLng = {lat: 12.9716, lng: 77.5946};
    var hydLatLng = {lat: 17.385044, lng: 78.486671};
    var ncrLatLng = {lat: 28.4595, lng: 77.0266};
    
    map1 = new google.maps.Map(document.getElementById('map1'), {
        zoom: 10.5,
        center: blrLatLng
    });
    map2 = new google.maps.Map(document.getElementById('map2'), {
        zoom: 10.5,
        center: hydLatLng
    });
    map3 = new google.maps.Map(document.getElementById('map3'), {
        zoom: 9.75,
        center: ncrLatLng
    });
}