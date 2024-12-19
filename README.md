```
  _      _______  _____  _______  ___________ 
 | | /| / /  _/ |/ / _ \/ __/ _ \/ __/ __/ _ \
 | |/ |/ // //    / // /\ \/ ___/ _// _// // /
 |__/|__/___/_/|_/____/___/_/  /___/___/____/
                                     (v1.3)
``` 

An application for displaying wind speed to a user by entering a location.  
Specifically catered to drone and RC aircraft pilots who want to quickly check conditions before flying.

## Version 1.3

- **Frontend**: Built in Vue
- **Backend**: Built in Java 
- **APIs Used**:  
    1. **Geocoding API**: Converts the zipcode input into latitude and longitude
    2. **Wind Data API**: Provides the current wind speed, gust speed and wind direction
    3. **Rest Controller**: Creates the API endpoint as the interface

## Possible Future Additions

- **User Interface**: Resign fontend to look like a physical device
- **Additional Data**: Adding more API calls for airspace information, rain conditions, temperature data, and which aircraft are suitable to fly
- **Database**: Implementing a database to store favorite locations and history for users (would require login)
