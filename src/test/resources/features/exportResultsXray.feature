Feature:
  @xray
  Scenario:
    Given url  "https://xray.cloud.getxray.app/api/v2/import/execution/cucumber"
    And header Content-Type = "application/json"
    And header Authorization = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJiNmNhZGQwNS1lMzQxLTNmMTctYjU1Zi00OTM0MTI4MWQ4MmEiLCJhY2NvdW50SWQiOiI3MTIwMjA6YTM0ZTZiNDMtY2M2Ny00MmQ1LWIwNGEtNTQxYjk5MWMyNzFjIiwiaXNYZWEiOmZhbHNlLCJpYXQiOjE3NDM0MTgwMTksImV4cCI6MTc0MzUwNDQxOSwiYXVkIjoiNzIzNTY1NDg1RDAzNEU4OEEzOEY0ODlEOTREMTFFMTciLCJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJzdWIiOiI3MjM1NjU0ODVEMDM0RTg4QTM4RjQ4OUQ5NEQxMUUxNyJ9.FcAE-K2-8wrxtiEGrFepYZ0xoo7Xmd94SJmNd01fJ_4"
    * request read("cucumber.json")
    * method post
    * print response