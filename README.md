```
  _      _______  _____  _______  ___________ 
 | | /| / /  _/ |/ / _ \/ __/ _ \/ __/ __/ _ \
 | |/ |/ // //    / // /\ \/ ___/ _// _// // /
 |__/|__/___/_/|_/____/___/_/  /___/___/____/
                                     (v1.1)
``` 

An application for displaying wind speed to a user by entering a location.  
Specifically catered to drone and RC aircraft pilots who want to quickly check conditions before flying.

## Version 1.1

- **Interface**: CLI interface that takes a zipcode as input and returns the current wind speed and gust speed (if present).
- **Built with**: Java
- **APIs Used**:  
    1. **Geocoding API**: Converts the zipcode input into latitude and longitude.  
    2. **Wind Data API**: Provides the current wind speed and gust data.

## Possible Future Additions

- **API Integration**: Expand the existing program and map it to an API using Spring Boot, with the goal of connecting to a real front-end.
- **Additional Data**: Adding more API calls for airspace information, rain conditions, and possibly temperature data.
- **Database**: Implementing a database to store favorite locations and history for users.
