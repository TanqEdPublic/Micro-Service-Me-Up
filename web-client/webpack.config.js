
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
        rules: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        cacheDirectory: true,
                        presets: [
                            ["env", {
                                "targets": {
                                    "node": "current"
                                }
                            }],
                            'react'
                        ]
                    }
                }]
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            }
        ]
    },
    plugins:[
        new webpack.ProvidePlugin({
            jQuery: 'jquery',
            $: 'jquery',
            jquery: 'jquery',
            Tether: 'Tether',
            tether: 'tether',
            Popper: ['popper.js', 'default']
        })
    ]
};

/*



* */


// exclude: /(node_modules)/,