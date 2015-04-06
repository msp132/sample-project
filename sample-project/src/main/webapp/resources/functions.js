loggedIn = false;
loc = window.location;
var signinCallback = function (authResult) {
	  console.log(loggedIn);
	  if (authResult['status']['signed_in']) {
	    // Update the app to reflect a signed in user
	    // Hide the sign-in button now that the user is authorized, for example:
	    document.getElementById('signinButton').setAttribute('style', 'display: none');
	    window.location="form";
	    loggedIn=true;
	    console.log("true");
	  } else if (authResult['status']['signed_in'] == false && loggedIn == true) {
		  loggedIn=false;
		  console.log("false");
		  document.getElementById('signinButton').setAttribute('style', 'display: block');
		 // if (window.location != "")
		    	window.location=loc;	  
	  } else {
	    // Update the app to reflect a signed out user
	    // Possible error values:
	    //   "user_signed_out" - User is signed-out
	    //   "access_denied" - User denied access to your app
	    //   "immediate_failed" - Could not automatically log in the user
	    console.log('Sign-in state: ' + authResult['error']);	   
	  }
	}