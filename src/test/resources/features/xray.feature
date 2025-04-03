Feature:
  @xray
  Scenario:
    Given url  "https://xray.cloud.getxray.app/api/v2/authenticate"
    And header Content-Type = "application/json"
    And header Accept = 'application/json'
    * request {"client_id": "723565485D034E88A38F489D94D11E17","client_secret": "49061d773899f0f538536b49bc60d517787c8c591d3f68efab6de36728aa8761x"}
    * method post
    * print response