This project use case is to drop a marker on the Google Maps when a latitude and longitude is given.

Let us say in a typical e-commerce application which deals with orders from customer at various locations, and just for vizualization we want to drop a beautiful marker on the Map at the place where the customer has ordered that too dynamically with live orders, this project enables it.

Something similar to this:
http://uberestimate.com/live/


How does it work ?

1. A backend application that will be listening to latitude and logintude when the order has placed.
2. Pass the latitude and longitude to UI and drop a marker.

How did I achieve?



Step 1: Exposed a web service using which OMS (Order Management System) sends the latitude and longitude of the order placed
Step 2: Web service after receiving pushes the lat long into kafka on a specific topic. (Producer)
Step 3: A kafka listener listening to that topic and broadcasts the lat long to the connected clients using web socket       protocol.

How did UI establish the continious connecton from UI and backend ?
    At the time of application start, we will have a socket server listening to connections from any end point.
    When ever a UI page loads(index.html) it establishes a web socket connction with backend.
