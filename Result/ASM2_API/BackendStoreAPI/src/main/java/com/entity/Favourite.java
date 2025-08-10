package com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Favourite", uniqueConstraints = @UniqueConstraint(name = "unique_user_video", columnNames = {"UserID", "VideoID"}))
public class Favourite {

	@Id
	@Column(name = "FavouriteId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long favouriteId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "VideoId", nullable = false)
	private Video video;

	@CreationTimestamp
	@Column(name = "FavouriteDate", updatable = false, nullable = false)
	private LocalDateTime favouriteDate;

	public Favourite(User user, Video video) {
		this.user = user;
		this.video = video;
	}
}
