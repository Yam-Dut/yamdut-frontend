mapboxgl.accessToken = "pk.eyJ1IjoiYWJoaXNoZWs2OSIsImEiOiJjbWo1M293aXowNjZ2M2VxeXp1dTF1eXRkIn0.cQDrUqeGYFyZcN8CmPpSwg";

const map = new mapboxgl.Map({
    container: "map",
    style: "mapbox://styles/mapbox/navigation-night-v1",
    center: [85.3240, 27.7172], // Kathmandu
    zoom: 13
});

// WebSocket for live tracking
const socket = new SockJS("http://localhost:8080/trip");
const stomp = Stomp.over(socket);

let driverMarker = null;

stomp.connect({}, () => {
    stomp.subscribe("/location/live", msg => {
        const loc = JSON.parse(msg.body);

        if (driverMarker === null) {
            driverMarker = new mapboxgl.Marker({ color: "red" })
                .setLngLat([loc.longitude, loc.latitude])
                .addTo(map);
        } else {
            driverMarker.setLngLat([loc.longitude, loc.latitude]);
        }
    });
});
