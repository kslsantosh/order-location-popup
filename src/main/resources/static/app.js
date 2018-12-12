var stompClient = null;
var markers = [];

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
    console.log("latitude")
    console.log(message["latitude"])
    console.log("longitude")
    console.log(message["longitude"])
    myLatLng = {lat: message["latitude"], lng: message["longitude"]}
    // myLatLng = {lat: -25.363, lng: 131.044};
    markers.push(new google.maps.Marker({
    position: myLatLng,
    map: map,
    animation: google.maps.Animation.DROP
    }));
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    connect();
});

window.initMap = function  initMap() {
    console.log("------Inside initMap()-----")
    var myLatLng = {lat: 20.7865394, lng: 77.62864351};
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 5,
        center: myLatLng
    });
}

