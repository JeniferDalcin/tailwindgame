/** @type {import('tailwindcss').Config} */
const defaultTheme = require('tailwindcss/defaultTheme')
const colors = require('tailwindcss/colors')

module.exports = {
  content: 
  [
    "./resources/public/index.html",
    "./src/**/*.cljs",
  ],
  
  corePlugins: {
    preflight: true
  },

  future: {
    removeDeprecatedGapUtilities: true,
    purgeLayersByDefault: true,
    defaultLineHeights: true,
    standardFontWeights: true
  },

  theme: {
    extend: {
      fontFamily: {
        sans: [
          'Inter',
          ...defaultTheme.fontFamily.sans,
        ],
        prose: ['Source Serif Pro', 'serif']
      }
    }
  }
}

