
import './App.css';
import Header from './components/shared/Header';
import Home from './pages/Home/Home';
import Room from './pages/Room/Room';

import { ThemeProvider } from '@mui/material';
import { createTheme } from '@mui/material/styles';
import {
    Routes,
    Route,
    useRoutes,
    NavLayout
} from 'react-router-dom';

const theme = createTheme({
  palette: {
    primary: {
      main: '#595622',
    },
    secondary: {
      main: '#8C3D2B',
    },
    // accent: {
    //   main: '#8C3D2B',
    //   contrastText: '#fff',
    // },
    // text: {
    //   primary: '#8C3D2B',
    // },
  },
  typography: {
    fontFamily: 'Amatic SC',
    // fontSize: '2rem',
    // fontSize: 16,
    body1: {
        fontSize: 24,
    },
    body2: {
        fontSize: 24,
    },
    button: {
      fontSize: '2rem',
      margin: 5,
    },
    table: {
        fontSize: 24
    }
  },
  
});


function App() {
    const routes = useRoutes([{
            index: true,
            element: <Home/>
        },
        {
            path:"/room",
            element: <Room/>
        }
    ]);

  return (
    <>
            <ThemeProvider theme={theme}>
                <Header />
                {/* <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/room" element={<Room />} />
                </Routes> */}
                {routes}

                {/* <Route component={Room} /> */}
            </ThemeProvider>
    </>
  );
}

export default App;
