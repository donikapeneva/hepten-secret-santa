import React, { useState } from 'react';  
import './Home.css';
import Button from '@mui/material/Button';
import { Typography } from '@mui/material';
import CreateRoomModal from '../../components/CreateRoomModal';

const Header = () => {

    const [open, setOpen] = useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => {
        console.log('>>> on close');
        setOpen(false);
    }

  return (
    <div className="container">
      <div className="accent-title">
      <Typography  variant="h1">
        Hepten Secret Santa
      </Typography>
      </div>
      <Button variant="outlined" onClick={handleOpen}>             
        Create room
      </Button>
      <CreateRoomModal open={open} onClose={handleClose}/>

      <Button variant="outlined"> 
        Enter room
      </Button>
      <Button>
        How does it work
      </Button>
    </div>
  );
};

export default Header;