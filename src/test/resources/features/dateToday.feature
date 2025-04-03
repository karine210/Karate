Feature: Test post



  Scenario: test post

    * def sdf = new java.text.SimpleDateFormat("MM-dd-yyyy")
    * def today = sdf.format(new java.util.Date())
    * def list = $response..createDate
    * def fun = function(x){ return x.startsWith(today) }
    * def filtered = karate.filter(list, fun)
    * assert filtered.size() != 0
    
    * print today