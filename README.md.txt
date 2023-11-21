# Hotel Reservation System API Documentation

## API Endpoints
 
### 1. Create a Reservation

- **Endpoint**: `POST /api/reservation/createReservation`
- **Description**: Create a new reservation.
- **Request**:

  ```json
  {
    "guestId": 1,
    "checkInDate": "2023-12-01",
    "checkOutDate": "2023-12-08"
  }
Response:
{
  "reservationId": 3,
  "checkInDate": "2023-12-01",
  "checkOutDate": "2023-12-08"
}
  
2. Update Reservation Dates

- **Endpoint**: `PUT /api/reservation/updateReservationDates/{reservationId}`
- **Description**: update reservation dates.
- **Request**:
  ```json

{
  "checkInDate": "2023-12-05",
  "checkOutDate": "2023-12-08"
}

Response:
  true

3. Cancel Reservation
- **Endpoint**: `PUT /api/reservation/updateReservationDates/{reservationId}`
- **Description**: Cancel a reservation by ID.
- **Request**:None

Response:
1/
{
    "flag": true,
    "msg": "Cancelled reservation successfully",
}
{
    "flag": false,
    "msg": "Failed to cancel reservation",
}

4. Get All Reservations by Guest ID
- **Endpoint**: `GET /api/reservation/guestIdWiseAllReservation/{guestId}`
- **Description**: Get a list of all reservations for a specific guest.
- **Request**:None
Response:
[
  {
    "reservationId": 1,
    "checkInDate": "2023-12-01",
    "checkOutDate": "2023-12-05"
  },
  {
    "reservationId": 3,
    "checkInDate": "2023-12-01",
    "checkOutDate": "2023-12-08"
  }
]

## Postman Collection

### Import Instructions:

1. Download the [Postman Collection JSON File](path-to-local-file.json).
2. Open Postman.
3. Click on the "Import" button in the top-left corner.
4. Choose the file you downloaded.
5. The collection will be imported into your local Postman instance.

