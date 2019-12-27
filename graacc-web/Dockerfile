FROM node:12.2.0-alpine

WORKDIR  /app

COPY . .

COPY package.json /app/package.json

RUN npm install react-scripts@3.0.1 -g

ENV PATH /app/node_modules/.bin:$PATH

CMD ["npm", "start"]