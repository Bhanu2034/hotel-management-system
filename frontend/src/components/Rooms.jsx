import { useEffect, useState } from "react";
import axios from "axios";

function Rooms() {
  const [rooms, setRooms] = useState([]);
  const [newRoom, setNewRoom] = useState({
    roomNo: "",
    type: "",
    pricePerNight: "",
    available: true,
  });

  // Fetch rooms on component load
  useEffect(() => {
    fetchRooms();
  }, []);

  const fetchRooms = () => {
    axios
      .get("http://localhost:8080/api/rooms")
      .then((response) => setRooms(response.data))
      .catch((error) => console.error("Error fetching rooms:", error));
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewRoom({ ...newRoom, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const roomData = {
      ...newRoom,
      pricePerNight: parseFloat(newRoom.pricePerNight),
    };

    axios
      .post("http://localhost:8080/api/rooms", roomData)
      .then(() => {
        fetchRooms(); // Refresh list after adding
        setNewRoom({ roomNo: "", type: "", pricePerNight: "", available: true });
      })
      .catch((error) => console.error("Error adding room:", error));
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial, sans-serif" }}>
      <h2>Add a Room</h2>
      <form onSubmit={handleSubmit} style={{ marginBottom: "20px" }}>
        <input
          type="text"
          name="roomNo"
          placeholder="Room Number"
          value={newRoom.roomNo}
          onChange={handleInputChange}
          required
        />
        <input
          type="text"
          name="type"
          placeholder="Room Type"
          value={newRoom.type}
          onChange={handleInputChange}
          required
          style={{ marginLeft: "10px" }}
        />
        <input
          type="number"
          name="pricePerNight"
          placeholder="Price per Night"
          value={newRoom.pricePerNight}
          onChange={handleInputChange}
          required
          style={{ marginLeft: "10px" }}
        />
        <button type="submit" style={{ marginLeft: "10px" }}>Add Room</button>
      </form>

      <h2>Available Rooms</h2>
      <ul>
        {rooms.length > 0 ? (
          rooms.map((room) => (
            <li key={room.id}>
              Room {room.roomNo} - {room.type} - ₹{room.pricePerNight} (
              {room.available ? "Available" : "Booked"})
            </li>
          ))
        ) : (
          <p>No rooms available.</p>
        )}
      </ul>
    </div>
  );
}

export default Rooms;
