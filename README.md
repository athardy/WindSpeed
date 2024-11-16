  _      _______  _____  _______  ___________ 
 | | /| / /  _/ |/ / _ \/ __/ _ \/ __/ __/ _ \
 | |/ |/ // //    / // /\ \/ ___/ _// _// // /
 |__/|__/___/_/|_/____/___/_/  /___/___/____/ 

An application for displaying wind speed to a user by entering a location
Will be specifically caitered to drone and rc aircraft pilots looking quickly check conditions before flying

v1.1 A CLI interface that takes a zipcode for input and returns the current wind speed and gust speed if present
  Built in Java and consumes two APIs: one for geocoding the zipcode input into latitude and longitude, and one for returning the wind data

Possible Future Additions
  Taking the existing program and mapping it to an API via springboot to eventually connect to a real front-end
  Adding more API calls and more data to give additional information about airspace, rain conditions, and possibly temp
  Connecting to a database for favorite locations and history
