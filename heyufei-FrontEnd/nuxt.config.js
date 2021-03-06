module.exports = {
  head: {
    title: '高考志愿平台',
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '{{escape description }}' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },

    ],
    script:[

    ]
  },
  plugins: [
    { src: '~plugins/element-ui', ssr: false },
    { src: '~plugins/vue-infinite-scroll', ssr: false },
    { src: '~plugins/nuxt-quill-plugin.js', ssr: false },
    { src: '~plugins/quill-image-extend-module.js', ssr: false }
  ],
  css: [
    'element-ui/lib/theme-chalk/index.css',
    'quill/dist/quill.snow.css',
    'quill/dist/quill.bubble.css',
    'quill/dist/quill.core.css',

  ],
  loading: { color: '#20e8ba' },
  build: {

  }
}

