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
                        <TextField id="standard-basic" label="Room Name" variant="standard" />
                        <TextField id="standard-basic" label="Pass Code" variant="standard" />

                        <FancySelect label="Code Names Theme"
                            source={codeNamesThemes}
                        />
                        <MultipleSelect label="Code Gift Theme"
                            source={giftThemes}
                        />

                        <TextField id="standard-basic" label="Budget" variant="standard" />
                        <FormControlLabel control={<Checkbox defaultChecked />} label="I want to know the gender" />

                        <Button variant="outlined">create room</Button>
                        {/* </FormGroup> */}
                </Stack>
            </Box>
          </Fade>
        </Modal>
      </div>
    );
  }

  export default CreateRoomModal;