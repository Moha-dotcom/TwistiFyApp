/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}" , "./build/**/*.html"],
  
  theme: {
    extend: {},
  },
  plugins: [
    tailwindcss('./tailwind.js'),
    require('autoprefixer')
],
}