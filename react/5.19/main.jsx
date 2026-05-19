import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import {LabComp1} from './LabComp1.jsx'
import {LabComp2} from './LabComp2.jsx'
import {LabComp3} from './LabComp3.jsx'
import {LabComp4} from './LabComp4.jsx'
import {LabComp5} from './LabComp5.jsx'
import {LabComp6} from './LabComp6.jsx'
import {LabComp7} from './LabComp7.jsx'
import {LabComp8} from './LabComp8.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <LabComp1 />
    <LabComp2 /> */}
    {/* <LabComp3 />
    <LabComp4 />
    <LabComp5 />
    <LabComp6 /> */}
    <LabComp7 />
    <LabComp8 />
  </StrictMode>,
)
