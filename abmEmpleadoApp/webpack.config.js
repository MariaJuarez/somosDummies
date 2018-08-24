module.exports = {
        entry: './src/main/js/app.js',
        devtool: 'sourcemaps',
        cache: true,
        debug: true,
        output: {
            path: __dirname,
            filename: './src/main/resources/static/built/bundle.js'
        },
        module: {
            loaders: [
                {
                    test:/\.js$/,
                    loader:"babel",
                    exclude:/node_modules/,
                    query: {
                        cacheDirectory: true,
                        presets: ['es2015', 'react']
                    }

                },
                {
                    test: /\.css$/,
                    loaders: [ 'style', 'css' ]
                },
                { test: /\.(png|jpg|jpeg)$/, loader: 'url' }
            ]

        }
};
