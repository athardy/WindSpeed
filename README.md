```
  _      _______  _____  _______  ___________ 
 | | /| / /  _/ |/ / _ \/ __/ _ \/ __/ __/ _ \
 | |/ |/ // //    / // /\ \/ ___/ _// _// // /
 |__/|__/___/_/|_/____/___/_/  /___/___/____/
                                     (v1.2)
``` 

An application for displaying wind speed to a user by entering a location.  
Specifically catered to drone and RC aircraft pilots who want to quickly check conditions before flying.

## Version 1.2

- **Interface**: An API endpoint than takes a zipcode as a HTTP parameter and returns a wind report in JSON
- **Built with**: Java
- **APIs Used**:  
    1. **Geocoding API**: Converts the zipcode input into latitude and longitude.  
    2. **Wind Data API**: Provides the current wind speed and gust data.
    3. **Rest Controller**: Creates the API endpoint as the interface

## Possible Future Additions

- **Better UI**: Style frontend with CSS
- **Friendlier UX**: Add more ways to receive report: zipcode, city + state, current location
- **Additional Data**: Adding more API calls for airspace information, rain conditions, and possibly temperature data.
- **Database**: Implementing a database to store favorite locations and history for users (would require login)
