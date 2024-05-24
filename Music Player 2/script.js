const songs = [
  {
    id: 1,
    name: "Balam-Pichkari",
    artist: "Arijit Singh",
    img: "thumbnails/Balam Pichkaari.jpg",
    genre: "Dance",
    src: "songs/Balam-Pichkari(PaglaSongs).mp3",
  },
  {
    id: 2,
    name: "Faded",
    artist: "Alan Walker",
    img: "thumbnails/faded.jpg",
    genre: "Hip-Hop",
    src: "songs/Faded.mp3",
  },
  {
    id: 3,
    name: "Goriya Churana",
    artist: "sonu Nigam, Alka Yagnik",
    img: "thumbnails/Goriya Churana.jpg",
    genre: "Pop",
    src: "songs/Goriya-Churana-Mera-Jiya(PaglaSongs).mp3",
  },
  {
    id: 4,
    name: "Heeriye",
    artist: "Arijit Singh",
    img: "thumbnails/heeriye.jpg",
    genre: "Jazz",
    src: "songs/Heeriye(PaglaSongs).mp3",
  },
  {
    id: 5,
    name: "Holi Biraj Ma",
    artist: "Jubin Nautiyal",
    img: "thumbnails/Holi biraj ma.jpg",
    genre: "Hip Hop",
    src: "songs/Holi-Biraj-Ma(PaglaSongs).mp3",
  },
  {
    id: 6,
    name: "Maan Meri Jaan",
    artist: "Don,t Know",
    img: "thumbnails/maan meri jaan.jpg",
    genre: "Pop",
    src: "songs/Mana-Meri-Jaan(PaglaSongs).mp3",
  },
  {
    id: 7,
    name: "Sajni Re",
    artist: "Arijit Singh",
    img: "thumbnails/sajni re.jpg",
    genre: "Rock",
    src: "songs/Sajni-Re.mp3",
  },
];

// toggle theme function to toggle light/dark mode
document.getElementById("toggle-theme").addEventListener("click", toggleTheme);
function toggleTheme() {
  const rootNode = document.documentElement;
  const currentBgColor = rootNode.style.getPropertyValue("--bg-color");
  if (
    !currentBgColor ||
    currentBgColor ===
      "linear-gradient(45deg, rgb(255, 255, 129), rgb(253, 251, 233))"
  ) {
    rootNode.style.setProperty(
      "--bg-color",
      "linear-gradient(45deg, rgb(110, 5, 5), rgb(44, 0, 0))"
    );
    rootNode.style.setProperty("--text-color", "white");
    rootNode.style.setProperty(
      "--btn-color",
      "linear-gradient(45deg, rgba(80, 21, 102, 0.619), rgb(214, 31, 31))"
    );
  } else {
    rootNode.style.setProperty(
      "--bg-color",
      "linear-gradient(45deg, rgb(255, 255, 129), rgb(253, 251, 233))"
    );
    rootNode.style.setProperty("--text-color", "black");
    rootNode.style.setProperty(
      "--btn-color",
      "linear-gradient(45deg, rgb(249, 132, 100), rgb(255, 250, 119))"
    );
  }
}

// Filter Songs function that will display the songs in the list according to the genre
function filterSongs() {
  showSongs(songs);
  document
    .getElementById("select-genre")
    .addEventListener("change", (event) => {
      const selectedGenre = event.target.value;
      if (selectedGenre === "All") {
        showSongs(songs);
      } else {
        const filteredSongs = songs.filter((song) => {
          return song.genre === selectedGenre;
        });
        showSongs(filteredSongs);
      }
    });
}
filterSongs();
// Function to display Songs
function showSongs(songs) {
  const songList = document.getElementById("song-list");
  songList.innerHTML = "";
  songs.forEach((song) => {
    const songElement = document.createElement("div");
    songElement.classList.add("song");
    songElement.id = song.id;
    songElement.style.cursor = "pointer";
    songElement.innerHTML = `
    <div class="song-img">
      <img src="${song.img}" alt="${song.name}">
    </div>
    <div class="song-description">
      <div class="name">${song.name}</div>
      <div class="art-name">${song.artist}</div>
    </div>
    `;
    songList.appendChild(songElement);
    songElement.addEventListener("click", () => {
      playSong(song.src);
      showSongDetails(song);
    });
  });
}

// function to play the song
function playSong(source) {
  const audio = document.getElementById("audio");
  if (audio.src !== source || audio.paused) {
    audio.src = source;
    audio.play();
  }
}

//show Song Details function to display the song details
function showSongDetails(song) {
  const songInfoElement = document.getElementById("song-info");
  songInfoElement.innerHTML = `<div class="thumbnail"><img src="${song.img}"></div>
            <div class="song-name">${song.name}</div>
            <div class="artist-name">${song.artist}</div>`;
}
showSongDetails(songs[0]);

// Event listener and function to be called when clicked next
document.getElementById("next-btn").addEventListener("click", nextSong);
function nextSong() {
  const audio = document.getElementById("audio");
  if (audio.src !== "") {
    let song = songs.find((song) => audio.src.slice(22) === song.src);
    let id = song.id + 1;
    song = songs.find((song) => song.id === id);
    playSong(song.src);
    showSongDetails(song);
  }
}

// Event Listener and function to be called when clicked previous
document.getElementById("prev-btn").addEventListener("click", prevSong);
function prevSong() {
  const audio = document.getElementById("audio");
  if (audio.src !== "") {
    let song = songs.find((song) => audio.src.slice(22) === song.src);
    let id = song.id - 1;
    song = songs.find((song) => song.id === id);
    playSong(song.src);
    showSongDetails(song);
  }
}

/*****************Now Creating a current Playlist and Add Playlist */
// for that we will create a new Playlist object
