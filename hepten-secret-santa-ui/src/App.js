
import './App.css';
import Header from './components/shared/Header';
import Home from './pages/Home/Home';

import { ThemeProvider } from '@mui/material';
import { createTheme } from '@mui/material/styles';

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
    button: {
      fontSize: '2rem',
      margin: 5,
    },
  },
  
});

function App() {
  return (
    <>
      <ThemeProvider theme={theme}>
        <Header />
        <Home />
      </ThemeProvider>
    </>
  );
}

export default App;