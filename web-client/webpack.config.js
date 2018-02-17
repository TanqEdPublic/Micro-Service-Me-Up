var path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: './src/main/reactjs/index.js',
    devtool: 'sourcemaps',
    cache: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            },
            {
                test: /\.css$/,

                loaders: ['style-loader', 'css-loader']
            }
        ]
    },
    plugins:[
        new webpack.ProvidePlugin({
            jQuery: 'jquery',
            $: 'jquery',
            jquery: 'jquery',
            Tether: 'Tether',
            tether: 'tether'
        })
    ]

};


// exclude: /(node_modules)/,