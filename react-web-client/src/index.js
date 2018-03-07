import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Application from './components/Applicaton-router';

import registerServiceWorker from './registerServiceWorker';
import 'bootstrap/dist/css/bootstrap.css';

ReactDOM.render(<Application />, document.getElementById('root'));
registerServiceWorker();
