<!DOCTYPE html>
<html>
    <head>
        <style>
            /* Set the size of the div element that contains the map */
            #map {
                height: 400px;  /* The height is 400 pixels */
                width: 100%;  /* The width is the width of the web page */
            }
        </style>
    </head>
    <body>
        <h3>My Google Maps Demo</h3>
        <!--The div element for the map -->
        <div id="map"></div>
        <%
            String lat = request.getParameter("lat");
            String lon = request.getParameter("lon");
        %>
        <script>
    // Initialize and add the map
            function initMap() {
                // The location of Uluru
                var uluru = {lat: <%=lat%>, lng: <%=lon %>};
                // The map, centered at Uluru
                var map = new google.maps.Map(
                        document.getElementById('map'), {zoom: 17, center: uluru});
                // The marker, positioned at Uluru
                var marker = new google.maps.Marker({position: uluru, map: map});
            }
        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAIZQHZcK_4ORIFMAkUkqj6p0hqhcAvRSE&callback=initMap">
        </script>
    </body>
</html>