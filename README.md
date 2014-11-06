HTTP Status Code Tester
========================

Running example: https://httpstatustester.herokuapp.com/

This is a super simple service for generating different HTTP codes written in http://ratpack.io
<br><br>
It's useful for testing how your own scripts deal with varying responses.
<br><br>
Just add the status code you want to the URL, like this: http://localhost:5050/?status=404&sleep=1000
<br><br>
 If you add <b>sleep<b> feature it will wait X milliseconds before replying. Useful for testing timeouts.
 
 Original idea from: http://httpstat.us/ however their is built in C# :(<br>
