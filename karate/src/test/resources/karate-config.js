function fn() {
    var env = karate.env;
    karate.log('karate.env system property was:', env);
    if (!env) {
        env = 'local';
    }
    var config = {
        helloWorldUrl: 'http://localhost:8080/helloWorld'
    };
    if (env === 'dev') {
        config.helloWorldUrl = 'https://dev-host/helloWorld';
    } else if (env === 'uat') {
        config.helloWorldUrl = 'https://uat-host/helloWorld';
    }

    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
