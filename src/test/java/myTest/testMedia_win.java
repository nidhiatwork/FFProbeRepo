package myTest;

import java.io.IOException;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;

public class testMedia_win {

public static void main(String[] args) throws IOException
{
	//FFmpeg ffmpeg = new FFmpeg("C:\\Users\\nbhushan\\Documents\\ffmpeg-3.4.1\\ffmpeg\\bin\\ffmpeg.exe");
	FFprobe ffprobe = new FFprobe("C:\\Users\\nbhushan\\Documents\\FFprobe\\ffprobe.exe");
	FFmpegProbeResult probeResult = ffprobe.probe("C:\\Users\\nbhushan\\Documents\\testData\\DreamLooks.MP4");

	FFmpegFormat format = probeResult.getFormat();
	System.out.format("%nFile: '%s' ; Format: '%s' ; Duration: %.3fs", 
		format.filename, 
		format.format_long_name,
		format.duration
	);

	FFmpegStream stream = probeResult.getStreams().get(0);
	System.out.format("%nCodec: '%s' ; Width: %dpx ; Height: %dpx",
		stream.codec_long_name,
		stream.width,
		stream.height
	);
}

}
