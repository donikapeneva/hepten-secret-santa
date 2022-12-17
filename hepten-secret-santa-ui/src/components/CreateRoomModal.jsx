import React, { useEffect, useState } from 'react';
import Backdrop from '@mui/material/Backdrop';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import Fade from '@mui/material/Fade';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import MultipleSelect from './MultipleSelect';
import FancySelect from './FancySelect';
import './CreateRoomModal.css';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';

// import ModalClose from '@mui/material/ModalClose';


const mockedCodeNameThemes = [
    'Famous People',
    'Friends',
    'Movies',
];

const mockedGiftThemes = [
    'Colors',
    'Adjectives',
];

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};


const CreateRoomModal = ({ open, onClose }) => {
    const [codeNamesThemes, setCodeNamesThemes] = useState();
    const [giftThemes, setGiftThemes] = useState();

    const [roomName, setRoomName] = useState();
    const [roomPass, setRoomPass] = useState();
    const [codeNamesThemeSelected, setCodeNamesThemeSelected] = useState('');
    const [giftThemesSelected, setGiftThemesSelected] = useState([]);
    const [budget, setBudget] = useState();
    const [genderReviel, setGenderReviel] = useState();

    const onRoomNameChange = (e) => setRoomName(e.target.value);
    const onRoomPassChange = (e) => setRoomPass(e.target.value);
    const onCodeNamesThemeSelectedChange = (e) => {
        setCodeNamesThemeSelected(e.target.value);
    };
    const onGiftThemesSelectedChange = (e) => {
        const { target: { value } } = e;
        setGiftThemesSelected(typeof value === 'string' ? value.split(',') : value);
    };
    const onBudgetChange = (e) => setBudget(e.target.value);
    const onGenderRevielChange = (e) => setGenderReviel(e.target.value);

    const handleCreateRoom = () => {
        const newRoomData = {
            roomName: roomName,
            roomPassCode: roomPass,
            codeNamesTheme: codeNamesThemeSelected,
            giftTheme: giftThemesSelected,
            budget: budget,
            genderReviel: genderReviel
        }
        //todo send to BE
    }

    useEffect(() => {
        setCodeNamesThemes(mockedCodeNameThemes);
        setGiftThemes(mockedGiftThemes);
    }, []);

    return (
      <div>
        <Modal
          aria-labelledby="transition-modal-title"
          aria-describedby="transition-modal-description"
          open={open}
          onClose={onClose}
          closeAfterTransition
          BackdropComponent={Backdrop}
          BackdropProps={{
            timeout: 500,
          }}
        >
          <Fade in={open}>
            <Box sx={style} className="form-field-center">
                <Stack
                    direction="column"
                    justifyContent="center"
                    alignItems="stretch"
                    spacing={2}
                    >
                        {/* <FormGroup> */}
                        <TextField 
                            id="standard-basic" 
                            label="Room Name" 
                            variant="standard" 
                            onChange={onRoomNameChange}
                        />
                        <TextField 
                            id="standard-basic"
                            label="Pass Code" 
                            variant="standard" 
                            onChange={onRoomPassChange}
                        />

                        <FancySelect 
                            label="Code Names Theme"
                            source={codeNamesThemes}
                            handleChange={onCodeNamesThemeSelectedChange}
                            value={codeNamesThemeSelected}
                        />
                        <MultipleSelect 
                            label="Code Gift Theme"
                            source={giftThemes}
                            handleChange={onGiftThemesSelectedChange}
                            value={giftThemesSelected}
                        />

                        <TextField 
                            id="standard-basic" 
                            label="Budget" 
                            variant="standard" 
                            onChange={onBudgetChange}
                        />
                        <FormControlLabel 
                            control={<Checkbox defaultChecked />} 
                            label="I want to know the gender" 
                            onChange={onGenderRevielChange}
                        />

                        <Button 
                            variant="outlined"
                            onClick={handleCreateRoom}>
                                create room
                            </Button>
                        {/* </FormGroup> */}
                </Stack>
            </Box>
          </Fade>
        </Modal>
      </div>
    );
  }

  export default CreateRoomModal;