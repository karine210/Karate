function fn(){
    var config = {
    urlServeur : 'https://restful-booker.herokuapp.com/'

    }

    karate.configure("connectTimeout", 5000);
    karate.configure("readTimeout", 5000);

    return config;

}