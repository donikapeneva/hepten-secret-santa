import React from 'react';
import Button from '@mui/material/Button';
import './Header.css';

import { useNavigate } from "react-router-dom";

const Header = () => {

    const navigate = useNavigate();
    return (
        <header>
            <div className="header-items">
                <Button onClick={() => navigate('/', { replace: false })}>
                    Home
                </Button>
                <Button>
                    My rooms
                </Button>
            </div>
        </header>
    );
};

export default Header;