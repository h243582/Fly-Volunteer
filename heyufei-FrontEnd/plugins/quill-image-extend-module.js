import Vue from 'vue'


import {container, ImageExtend, QuillWatch} from 'quill-image-extend-module'
import {Quill} from "vue-quill-editor/dist/ssr";

Quill.register('modules/ImageExtend', ImageExtend)

Vue.use({container, ImageExtend, QuillWatch})