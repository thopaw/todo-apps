FROM node:alpine

COPY ./server /app/server/
COPY package*.json /app/

EXPOSE 8000

WORKDIR /app/

RUN npm install

ENTRYPOINT ["node", "server/app.js"]
